#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    //write your code here and change the return value
    return null;
    }
        
};

int main() {
    Solution solution;
    
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    
    vector<int> nums(n);
    cout << "Enter the elements:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    
    int target;
    cout << "Enter the target sum: ";
    cin >> target;
    
    vector<int> result = solution.twoSum(nums, target);
    cout << result << endl;
    
    return 0;
}
