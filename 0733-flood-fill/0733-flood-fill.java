class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldcolor = image[sr][sc];

        if (oldcolor == color) {
            return image;
        }

        helper(image, oldcolor, sr, sc, color);

        return image;
        //return
    }

    public void helper(int[][] img, int oldColor, int i, int j, int newColor) {
        if (i < 0 ||
                j < 0 ||
                i >= img.length ||
                j >= img[0].length ||
                img[i][j] != oldColor) {
            return;
        }

        img[i][j] = newColor;

        helper(img, oldColor, i + 1, j, newColor); // bottom
        helper(img, oldColor, i - 1, j, newColor); // top
        helper(img, oldColor, i, j - 1, newColor); // left
        helper(img, oldColor, i, j + 1, newColor); // right

        // return
    }
}