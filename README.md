# Hole Filling

Given an image which each pixel is between [0,1], and a hole inside the image defined by pixels with value of -1, the algorithm should fill the hole.

The excercise implemented with Java.

To run it, just run **Test.java** and follow the output.

If the hole is a square with size of n\*n, then the hole size is n\*n.
So the algorithm complexity is **O(n^2)** at worst case.

The algorithm can be improved by using DFS/BFS.

**Notice that we can implement recursive Flood Fill algorithm (built-in in OpenCV), but as mentioned the propuse of this excersice is not to show algorithms skills.**
