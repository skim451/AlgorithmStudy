if __name__ == '__main__':
	numeric = '0123456789'

	numInput = int(input())

	numList = []

	for _ in range(numInput):
		line = input()
		number = 0
		flag = False
		for char in line:
			if char in numeric:
				number *= 10
				number += int(char)
				flag = True
			else:
				if flag:
					numList.append(number)
				flag = False
				number = 0
		if flag:
			numList.append(number)

	numList.sort()

	for num in numList:
		print(num)
