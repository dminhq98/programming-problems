#!/usr/bin/ruby

def make_bst(arr)

	sol = []

	arr.each do |z|
		x = 0
		until sol[x] == nil do
			if sol[x] > z then
				x = x*2 + 1 # left child
			else
				x = x*2 + 2 # right child
			end
		end
		sol[x] = z
	end

	sol
end

def inorder_traversal(bst, start)
	x = start
	par = nil
	inorder_traversal(bst, x*2+1) if bst[x*2+1] != nil
	p bst[x]
	inorder_traversal(bst, x*2+2) if bst[x*2+2] != nil
end

a = [ 5, 3, 2, 1, 12, 14, 9, 7, 17, 21 ]

b = make_bst(a)

inorder_traversal(b, 0)
