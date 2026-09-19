class Solution {
    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        return getPoint(r, xc, yc, x1, y1, x2, y2);
    }

    public boolean getPoint(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        int closex = 0;
        int closey = 0;
        //x conditons
        if (x1 > xc) {
            closex = x1;
        } else if (xc > x2) {
            closex = x2;
        } else {
            closex = xc;
        }

        //x conditons
        if (y1 > yc) {
            closey = y1;
        } else if (yc > y2) {
            closey = y2;
        } else {
            closey = yc;
        }

        long dx = closex - xc;
        long dy = closey - yc;

        return dx * dx + dy * dy <= (long) r * r;
    }
}