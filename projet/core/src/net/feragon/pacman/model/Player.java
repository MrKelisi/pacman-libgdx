package net.feragon.pacman.model;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameElement {
	private Direction _direction;
	private Direction _nextDirection;
	private Vector2 _origin;
	private int _points;
	
	public Player(Vector2 position, World world) {
		super(position, world);
		_origin = position;
		_direction = Direction.LEFT;
		_nextDirection = Direction.LEFT;
		_points = 0;
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
	 * @return int Points du joueur
	 */
	public int points() {
		return _points;
	}

	/**
	 * Ajoute des points au joueur
	 * @param points nombre de points
	 */
	public void addPoints(int points) {
		_points += points;
	}
	
	/**
	 * Donne le vecteur de déplacement
	 * @return Vecteur de déplacement
	 */
	private Vector2 getMoveVector() {
		switch(direction()) {
	        case UP:    
	        	return new Vector2(0, 1);
	        	
	        case RIGHT:
	        	return new Vector2(1, 0);
	        	
	        case DOWN: 
	        	return new Vector2(0, -1);
	        	
	        case LEFT: 
	        	return new Vector2(-1, 0);
		}
		
		return new Vector2(0, 0);
	}
	
	/**
	 * Donne la prochaine position du joueur
	 * @return Prochaine position
	 */
	private Vector2 getNextPosition() {
		return _origin.cpy().add(getMoveVector());
	}
	
	/**
	 * Déplace le joueur d'une case complète
	 */
	public void move() {
		Vector2 newPos = getNextPosition();

        if(world.getMaze().get(newPos) == null) {
            if(newPos.x == -1) {
                setPosition(new Vector2(world.getWidth() - 1, newPos.y));
            }
            else if(newPos.x == world.getWidth()) {
            	setPosition(new Vector2(0, newPos.y));
            }
            
            setPosition(newPos);
        }
	}
	
	/**
	 * Déplace le joueur précisément
	 * @param timeElapsed Temps écoulé depuis le dernier déplacement complet
	 * @TODO: la recherche de position peut être optimisée
	 */
	public void move(float timeElapsed) {
		Vector2 newPos = getNextPosition();
		Vector2 oldOrigin = _origin.cpy();

        if(world.getMaze().get(newPos) == null) {
        	Vector2 moveVector = getMoveVector().scl(timeElapsed);
    		setPosition(_origin.cpy().add(moveVector));
        }
        
        _origin = oldOrigin;
	}
}
