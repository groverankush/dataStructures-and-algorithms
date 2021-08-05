package com.ankushgrover.prep;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/07/21
 */
public class I47LCHCountOFSmallerNumbersAfterSelf {

    public static void main(String[] args) {

        I47LCHCountOFSmallerNumbersAfterSelf obj = new I47LCHCountOFSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};
        System.out.println(obj.countSmaller(nums));

    }

    public List<Integer> countSmaller(int[] nums) {

        //return treeMapApproach(nums);
        //return sortAndCount(nums);
        return sortAndCountCopied(nums);
    }

    public List<Integer> sortAndCountCopied(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<Integer>();
        int n = nums.length;
        int[] result = new int[n];

        ArrayValWithOrigIdx[] newNums = new ArrayValWithOrigIdx[n];
        for (int i = 0; i < n; ++i) newNums[i] = new ArrayValWithOrigIdx(nums[i], i);

        mergeSortAndCount(newNums, 0, n - 1, result);

        // notice we don't care about the sorted array after merge sort finishes.
        // we only wanted the result counts, generated by running merge sort
        List<Integer> resultList = new LinkedList<Integer>();
        for (int i : result) resultList.add(i);
        return resultList;
    }

    private void mergeSortAndCount(ArrayValWithOrigIdx[] nums, int start, int end, int[] result) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSortAndCount(nums, start, mid, result);
        mergeSortAndCount(nums, mid + 1, end, result);

        // left subarray start...mid
        // right subarray mid+1...end
        int leftPos = start;
        int rightPos = mid + 1;
        LinkedList<ArrayValWithOrigIdx> merged = new LinkedList<ArrayValWithOrigIdx>();
        int numElemsRightArrayLessThanLeftArray = 0;
        while (leftPos < mid + 1 && rightPos <= end) {
            if (nums[leftPos].val > nums[rightPos].val) {
                // this code block is exactly what the problem is asking us for:
                // a number from the right side of the original input array, is smaller
                // than a number from the left side
                //
                // within this code block,
                // nums[rightPos] is smaller than the start of the left sub-array.
                // Since left sub-array is already sorted,
                // nums[rightPos] must also be smaller than the entire remaining left sub-array
                ++numElemsRightArrayLessThanLeftArray;

                // continue with normal merge sort, merge
                merged.add(nums[rightPos]);
                ++rightPos;
            } else {
                // a number from left side of array, is smaller than a number from
                // right side of array
                result[nums[leftPos].originalIdx] += numElemsRightArrayLessThanLeftArray;

                // Continue with normal merge sort
                merged.add(nums[leftPos]);
                ++leftPos;
            }
        }

        // part of normal merge sort, if either left or right sub-array is not empty,
        // move all remaining elements into merged result
        while (leftPos < mid + 1) {
            result[nums[leftPos].originalIdx] += numElemsRightArrayLessThanLeftArray;

            merged.add(nums[leftPos]);
            ++leftPos;
        }
        while (rightPos <= end) {
            merged.add(nums[rightPos]);
            ++rightPos;
        }

        // part of normal merge sort
        // copy back merged result into array
        int pos = start;
        for (ArrayValWithOrigIdx m : merged) {
            nums[pos] = m;
            ++pos;
        }
    }

    private List<Integer> sortAndCount(int[] nums) {

        System.out.println("Unsorted: " + Arrays.toString(nums));

        Holder[] arr = new Holder[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Holder(nums[i], i);
        }

        int[] res = new int[nums.length];

        sort(arr, 0, nums.length - 1, res);


        System.out.println("Sorted: " + Arrays.toString(res));

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(res[i]);
        }

        return list;
    }

    private void sort(Holder nums[], int start, int end, int[] res) {

        if (start >= end)
            return;

        int mid = (start + end) / 2;
        sort(nums, start, mid, res);
        sort(nums, mid + 1, end, res);

        merge(nums, start, mid, end, res);

    }

    private void merge(Holder nums[], int start, int mid, int end, int res[]) {

        Holder[] temp = new Holder[end - start + 1];

        int index = 0;

        int left = start;
        int right = mid + 1;

        int count = 0;
        while (left <= mid && right <= end) {

            if (nums[left].val > nums[right].val) {
                count++;
                temp[index++] = nums[right++];

            } else {

                res[nums[left].index] += count;
                temp[index++] = nums[left++];


            }

        }

        while (left <= mid) {
            res[nums[left].index] += count;
            temp[index++] = nums[left++];
        }

        while (right <= end) {
            temp[index++] = nums[right++];
        }

        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = temp[index++];
        }

    }

    private List<Integer> treeMapApproach(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        LinkedList<Integer> list = new LinkedList<>();

        int i = nums.length - 1;

        int count = 0;
        int key = nums[i];

        while (i >= 0) {

            Map.Entry<Integer, Integer> entry = map.lowerEntry(key);
            if (entry == null) {
                list.addFirst(count);
                count = 0;
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                i--;
                if (i >= 0) {
                    key = nums[i];
                }
            } else {
                count += entry.getValue();
                key = entry.getKey();
            }
        }

        return list;

    }

    private class ArrayValWithOrigIdx {
        int val;
        int originalIdx;

        public ArrayValWithOrigIdx(int val, int originalIdx) {
            this.val = val;
            this.originalIdx = originalIdx;
        }
    }

    class Holder {

        int val;
        int index;

        Holder(int val, int index) {

            this.val = val;
            this.index = index;

        }
    }
}