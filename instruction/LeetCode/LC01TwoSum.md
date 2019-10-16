# LeetCode 01 TwoSum

Website:  [LeetCode 01 TwoSum](https://leetcode-cn.com/problems/two-sum/)

## 暴力法 (Force)
对数组遍历，从0开始往后找一个x , 符合Target = numbers[0] + x 的值。

```
private static int[] twoSumForce(int[] numbers, int target) {
    int i, j;
    for (i = 0; i < numbers.length - 1; i++) {
        for (j = i + 1; j < numbers.length; j++) {
            if (numbers[j] == target - numbers[i]) {
            return new int[]{i, j};
            }
        }
    }
    throw new IllegalArgumentException("no result");
}

```

因为做了两次遍历，所以时间复杂度是O(n * n)。

## Hash 优化
面对数据量比较大的时候，可以采用HashMap来进行性能优化。
* 使用HashMap会增加空间复杂度。
* HashMap.contains(key) 的平均时间复杂度为O(1)。虽然最差情况为O(n)，但是很少见。

### 两遍循环
这里使用了两边循环，第一遍循环初始化HashMap，第二遍循环去查找元素。时间复杂度为O(2n) -> O(n)。
ps: 两遍循环的方法，当numbers = [3,3,3,3] ,taret = 6时，会输入[0,3]，而不是[0,1]。这和HashMap中的链表有关，可以细品HashMap的源码。
```
private static int[] twoSumTwoHash(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
        map.put(numbers[i], i);
    }
    for (int i = 0; i < numbers.length; i++) {
        int number = target - numbers[i];
        if (map.containsKey(number) && map.get(number) != i) {
            return new int[]{i, map.get(target - numbers[i])};
        }
    }
    throw new IllegalArgumentException("no result");
}
```


### 一遍循环
```
private static int[] twoSumOneHash(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
        int number = target - numbers[i];
        if (map.containsKey(number)) {
            return new int[]{map.get(number), i};
        }
        map.put(numbers[i], i);
    }
    throw new IllegalArgumentException("no result");
}
```
使用了一遍循环，将赋值HashMap和查找放在了一次遍历中。时间复杂度O(n)

## 测试结果

Input

```
int[] testNumbers = new int[100003];
for (int i = 0; i < 100001; i++) {
    testNumbers[i] = 100000;
}
testNumbers[100001] = 2;
testNumbers[100002] = 4;

int target = 6;

testTwoSumForce(testNumbers, target);

testTwoSumTwoHash(testNumbers, target);

testTwoSumOneHash(testNumbers, target);

```

Output:
```
Force Hash Time Used: 1140ms; result :100001 100002

Two Hash Time Used: 22ms; result :100001 100002

One Hash Time Used: 18ms; result :100001 100002

```

