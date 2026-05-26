// Last updated: 5/26/2026, 12:33:03 PM
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        row.add(1); // C(rowIndex, 0)

        for (int i = 1; i <= rowIndex; i++) {
            val = val * (rowIndex - i + 1) / i;
            row.add((int) val);
        }

        return row;
    }
}
