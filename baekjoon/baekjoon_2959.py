if __name__ == '__main__':
	numList = [int(x) for x in input().split()]

	numList.sort()

	print(numList[0] * numList[2])