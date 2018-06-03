package net.feragon.pacman.model;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameElement {
	private Direction _direction;
	private Vector2 _origin;
	private Vector2 _startPos;
	
	public Player(Vector2 position, World world) {
		super(position, world);
		_origin = position;
		_startPos = new Vector2(0,0);
		_direction = Direction.LEFT;
	}

	@Override
	public void setPosition(Vector2 position) {
		super.setPosition(position);
		_origin = position;
	}

	/**
	 * @return Direction du joueur
	 */
	public Direction direction() {
		return _direction;
	}

	/**
	 * Change la direction du joueur
	 * @param direction Nouvelle direction
	 */
	public void setDirection(Direction direction) {
		if(direction == null) {
			throw new NullPointerException("Direction null");
		}
		_direction = direction;
	}

	/**
	 * Donne la position d'origine du joueur
	 * @return Position d'origine
	 */
	public Vector2 getOrigin() {
		return _origin;
	}

	/**
	 * Donne la prochaine position du joueur
	 * @return Prochaine position
	 */
	protected Vector2 getNextPosition(Direction direction) {
		return _origin.cpy().add(direction.moveVector());
	}
	
	/**
	 * Déplace le joueur d'une case complète
	 */
	public void move() {
		Vector2 newPos = getNextPosition(_direction);

        if(isElementAccessible(world.getMaze().get(newPos))) {
        	if(newPos.x < 0) {
                newPos.set(world.getWidth() - 1, newPos.y);
            }
            else if(newPos.x > world.getWidth() - 1) {
            	newPos.set(0, newPos.y);
            }
            
            setPosition(newPos);
        }
        else {
        	newPos = _origin.cpy();
        }
	}
	
	/**
	 * Déplace le joueur précisément
	 * @param timeElapsed Temps écoulé depuis le dernier déplacement complet
	 */
	public void move(float timeElapsed) {
		Vector2 newPos = getNextPosition(_direction);
		Vector2 oldOrigin = _origin.cpy();

        if(isElementAccessible(world.getMaze().get(newPos))) {
        	Vector2 moveVector = direction().moveVector().scl(timeElapsed / World.TICK_TIME);
    		setPosition(_origin.cpy().add(moveVector));
    		_origin = oldOrigin;
        }
	}

	/**
	 * Initialise la position de départ du joueur comme défini dans le level
	 */
	public void setStartPos() {
		_startPos = _origin;
	}

	/**
	 * Retourne la position de départ
	 * @return la position de départ
	 */
	public Vector2 getStartPos() {
		return _startPos;
	}

	/**
	 * Replace le joueur à sa position de départ
	 */
	public void resetPosition() {
		setPosition(_startPos);
		_direction = Direction.LEFT;
	}
	
	/**
	 * @param ge Élément
	 * @return Vrai si l'élément ne bloque pas le joueur
	 */
	protected boolean isElementAccessible(GameElement ge) {
		return !(ge instanceof Blocking);
	}
}
