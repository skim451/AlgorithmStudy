from math import ceil, sqrt

def isPerfectNum(num):
	mid = ceil(sqrt(num))
	sumSoFar = 1
	divisorList = []
	for i in range(2, mid):
		if num % i == 0:
			sumSoFar += i
			divisorList.append(i)
			sumSoFar += num / i
			divisorList.append(int(num / i))
	divisorList = sorted(divisorList)

	if sumSoFar == num:
		tempStr = '1'
		for divisor in divisorList:
			tempStr += ' + ' + str(divisor)
		print(str(num) + ' = ' + tempStr)
	else:
		print(str(num) + ' is NOT perfect.')

if __name__ == '__main__':
	while True:
		thisInput = int(input())
		if thisInput == -1:
			break
		isPerfectNum(thisInput)

