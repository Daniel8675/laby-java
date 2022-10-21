package agh.ics.oop;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction){

        if (direction == MoveDirection.RIGHT) {
            switch (this.orientation){
                case NORTH -> this.orientation = MapDirection.EAST;
                case EAST -> this.orientation = MapDirection.SOUTH;
                case SOUTH -> this.orientation = MapDirection.WEST;
                case WEST -> this.orientation = MapDirection.NORTH;
            }

        } else if (direction == MoveDirection.LEFT) {
            switch (this.orientation){
                case NORTH -> this.orientation = MapDirection.WEST;
                case EAST -> this.orientation = MapDirection.NORTH;
                case SOUTH -> this.orientation = MapDirection.EAST;
                case WEST -> this.orientation = MapDirection.SOUTH;
            }
        } else if (direction == MoveDirection.FORWARD) {
            switch (this.orientation){
                case NORTH -> this.position = this.position.y <  4 ? this.position.add(new Vector2d(0,1))  : this.position;
                case EAST ->  this.position = this.position.x <  4 ? this.position.add(new Vector2d(1,0))  : this.position;
                case SOUTH -> this.position = this.position.y > -4 ? this.position.add(new Vector2d(0,-1)) : this.position;
                case WEST ->  this.position = this.position.x > -4 ? this.position.add(new Vector2d(-1,0)) : this.position;
            }
        } else {
            switch (this.orientation){
                case NORTH -> this.position = this.position.y > -4 ? this.position.add(new Vector2d(0,-1)) : this.position;
                case EAST -> this.position  = this.position.x > -4 ? this.position.add(new Vector2d(-1,0)) : this.position;
                case SOUTH -> this.position = this.position.y <  4 ? this.position.add(new Vector2d(0,1))  : this.position;
                case WEST -> this.position  = this.position.x <  4 ? this.position.add(new Vector2d(1,0))  : this.position;
            }
        }


    }

}
