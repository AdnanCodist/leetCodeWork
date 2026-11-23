class ProductOfNumbers {

    ArrayList<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {

        if (num == 0) {
            list.clear();
            return;
        }

        if (list.isEmpty()) {
            list.add(num);
        } else {

            int last = list.get(list.size() - 1);
            list.add(last * num);
        }
    }

    public int getProduct(int k) {
        int n = list.size();

        // quick cases
        if (n == k) {
            return list.get(list.size() - 1);
        }

        if (n < k) {
            return 0;
        }

        int ans = list.get(list.size() - 1) / list.get(n - k - 1);

        return ans;
    }
}

// algo explained :- 

// [2, 3, 4, 5]
// [2, 6, 24, 120]

// get k = 2 -> last do element, 5 && 4 hai
// n-k-1 = 4 - 2 - 1 = 1
// 120 / 6 = 20

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */