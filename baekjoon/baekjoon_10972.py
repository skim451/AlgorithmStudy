def nextPermutation(curr):
	end = len(curr) - 1
	i = end
	j = i - 1

	while curr[j] > curr[i]:
		if j == 0:
			return [-1]
		j -= 1
		i -= 1

	while not (curr[end] > curr[j]):
		end -= 1

	curr[end], curr[j] = curr[j], curr[end]
	curr[j + 1:] = reversed(curr[j + 1:])
	return curr


if __name__ == '__main__':
	_ = int(input())
	nums = [int(x) for x in input().split()]
	answer = nextPermutation(nums)

	ansStr = str(answer.pop(0))
	for i in answer:
		ansStr += ' ' + str(i)

	print(ansStr)

