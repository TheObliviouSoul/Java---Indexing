### Simplified Explanation of the Assignment 2 Document

**Assignment Overview:**
- This assignment builds on the Warehouse database from Assignment 1, using the same dataset.

**Key Concepts:**
- **Index:** A data structure for faster query and retrieval of data.
- **Index Creation:** Allows sorting records without changing their original order in the database.

**Tasks:**
1. **Add a New Member Function to the Dictionary ADT:**
   - Implement a method to create an index based on an attribute, either in ascending or descending order.
   - The index will be an array of positions sorted by the specified attribute, without changing the original order of records.
   - Discuss time and space complexity in comments.

2. **Binary Search Tree (BST) Index:**
   - Implement the index as a BST and use in-order traversal to produce the sorted order.

3. **Query Method:**
   - Implement a method in the WarehouseInventory class to query and print the N-th percentile value based on an attribute.
   - Ensure the attribute has an index created beforehand.

4. **Unit Test Cases:**
   - Develop two unit test cases to query two different attributes using the query method. Ensure both tests pass.

**Submission Instructions:**
- Combine all Java files into one `src` folder.
- Archive the folder as a single file (`ZIP`, `GZ`, or `TAR`) using the specified naming convention.
- Submit through Moodle by the deadline. Email submissions are not accepted.
- A grace period of 6 hours is allowed, with a 20% penalty for submissions up to 24 hours late.
