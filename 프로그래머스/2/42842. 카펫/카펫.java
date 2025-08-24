class Solution {
    public int[] solution(int brown, int yellow) {
        // (width + height - 2) * 2
        // (width * height) - (width + height - 2) * 2
        // 노란색 격자는 1 이상. 한개 이상 있으려면 3*3이 필요하다.
        // 갈색 격자는 5000개 이하.
        for (int width = 3; width <= 5000; width++) {
            for(int height = 3; height <= width; height++) {
                int boundary = (width + height - 2) * 2;
                int center = (width * height) - boundary;
                if (brown == boundary && yellow == center) {
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }
}
