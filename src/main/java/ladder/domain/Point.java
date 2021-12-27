package ladder.domain;

import ladder.util.RandomUtil;

public class Point {
    private final Position position;
    private final MoveDirection moveDirection;

    public Point(Position position, MoveDirection moveDirection) {
        this.position = position;
        this.moveDirection = moveDirection;
    }

    public static Point first(boolean right) {
        return new Point(new Position(0), MoveDirection.first(right));
    }

    public Position move() {
        if (moveDirection.canMoveLeft()) {
            return position.before();
        }
        if (moveDirection.canMoveRight()) {
            return position.next();
        }
        return position;
    }

    public Point next() {
        return next(RandomUtil.randomBoolean());
    }

    public Point next(boolean right) {
        return new Point(position.next(), moveDirection.next(right));
    }
}
