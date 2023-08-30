class Submit:
    def twoSum(self, nums, target):
        numToIndex = {}

        for i, num in enumerate(nums):
            complement = target - num

            # Check if the complement exists in the dictionary
            if complement in numToIndex:
                return [numToIndex[complement], i]  # Found the solution

            # Add current number and index to the dictionary
            numToIndex[num] = i

        # No solution found
        return []

solution = Submit()
for i in range(3):
    n = int(input())
    nums = []
    for _ in range(n):
        nums.append(int(input()))
    target = int(input())

    result = solution.twoSum(nums, target)
    if len(result) == 2:
        print(f"[{result[0]} {result[1]}]")
    else:
        print("null")
