if __name__ == '__main__':
	size = int(input())
	rope = []
	for i in range(size):
		rope.append(int(input()))
	rope = sorted(rope)

	answer = 0
	for i in range(size):
		answer = max(answer, (size - i) * rope[i])

	print(answer)