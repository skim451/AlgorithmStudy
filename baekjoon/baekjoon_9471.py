def	solve(num):
	prevVal = 1
	currVal = 1

	cycleList = [prevVal, currVal]
	checkList = []
	index = 0

	while True:
		if len(cycleList) == len(checkList):
			break

		nextVal = (prevVal + currVal) % num
		checkList.append(nextVal)

		if nextVal == cycleList[index]:
			index += 1
		else:
			cycleList.extend(checkList)
			checkList = []
			index = 0

		prevVal = currVal
		currVal = nextVal

	return len(cycleList)

if __name__ == '__main__':
	numTestCases = int(input())
	for _ in range(numTestCases):
		testCase, m = [int(x) for x in input().split()]
		print(testCase, solve(m))