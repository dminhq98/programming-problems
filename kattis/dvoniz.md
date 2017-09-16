Helpful observations:
- The left and right sides must both be less than or equal to S. Therefore, left+right must be less than or equal to 2S.
- The ith answer will be at least two less than the previous one. To illustrate: if we have the input sequence 1 2 3 1 2 3 4 5 6, and S=6, then the first answer will be 6 (left: 1 2 3; right: 1 2 3). By lopping off the first element of the left list (effectively moving us forward one in order to consider the next case, as we should) and the last element of the right list (so now left: 2 3; right: 1 2), we have two (slightly smaller) lists that we are *certain* are acceptable. Why? Because they are sub-lists of a known acceptable answer. This saves us *a lot* of work.

So, the algorithm goes like this:


	While there is input:
		Until left+right > 2*S:
			Grab two (more) input items.
		Until left <= S and right <= S:
			Drop the last two input items.
		Output the number of items.
		Drop the first and last elements.


An exercise for the reader: What is the big-O runtime of this algorithm? (hint: convince yourself of how it is not O(N^2).)
