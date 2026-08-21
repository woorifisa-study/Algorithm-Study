class Solution
{
    public int solution(int n, int a, int b)
    {

        int nextA = a;
        int nextB = b;
        int round = 0;
        while (nextA != nextB) {
            nextA = (nextA + 1) / 2;
            nextB = (nextB + 1) / 2;
            round++;
        }

        return round;
    }
}