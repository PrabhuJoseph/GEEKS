package binarysearch;


// HIndex for Sorted Citations - Non-Increasing Order

// https://www.geeksforgeeks.org/find-h-index-for-sorted-citations-using-binary-search/

class HIndex{

    // Function to find the H-index
    static int hIndex(int[] citations, int n)
    {
        int hindex = 0;

        // Set the range for binary search
        int low = 0, high = n - 1;

        while (low <= high)
        {
            int mid = (low + high) / 2;
            System.out.println(low + "----" + high + "---" + mid);

            // Check if current citations is
            // possible
            if (citations[mid] >= (mid + 1))
            {

                // Check to the right of mid
                low = mid + 1;

                // Update h-index
                hindex = mid + 1;
            }
            else
            {

                // Since current value is not
                // possible, check to the left
                // of mid
                high = mid - 1;
            }
        }

        // Print the h-index
        System.out.println(hindex);

        return hindex;
    }

    // Driver Code
    public static void main (String[] args)
    {

        // citations
        int n = 5;
        int[] citations = { 5, 4, 2, 1, 1 };

        hIndex(citations, n);
    }
}

// This code is contributed by sanjoy_62

