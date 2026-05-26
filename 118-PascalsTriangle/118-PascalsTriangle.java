// Last updated: 5/26/2026, 12:33:05 PM
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        // Initialize with the first row: [1]
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> prev = res.get(res.size() - 1);

            // Create padded temp: [0] + prev + [0]
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.addAll(prev);
            temp.add(0);

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < prev.size() + 1; j++) {
                row.add(temp.get(j) + temp.get(j + 1));
            }

            res.add(row);
        }

        return res;
    }
}
