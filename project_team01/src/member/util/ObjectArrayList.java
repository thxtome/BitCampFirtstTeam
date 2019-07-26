package member.util;

import java.util.Arrays;

public class ObjectArrayList {
	final int CAPACITY = 10;
	Object[] elements = new Object[CAPACITY];
	int pos = 0;
	int ObjectNo = 0;

	public String toString() {
		if (pos == 0)
			return "ArrayList[]";

		String result = "";
		for (int i = 0; i < pos; i++) {
			if (result == "") {
				result = result + "[" + elements[i];
				continue;
			}
			result = result + "," + elements[i];
		}
		result = "ArrayList" + result + "]";
		return result;
	}

	// 배열에 값을 더함
	public void add(Object Object) {
		add(pos, Object);
	}

	// 배열의 인덱스 값으로 출력
	public Object get(int index) {
		return elements[index];
	}
	
	// 갯수 측정	int size() {
	public int size() {
		return pos;
	}

	// 삭제
	public void remove(int no) {
		int num = pos - no - 1;
		if (num > 0) {
			System.arraycopy(elements, no + 1, elements, no, num);
			elements[--pos] = null;
			return;
		}
		return;
	}

	// 전체 삭제 사용안함
	public void clear() {
		Object[] arr = new Object[elements.length];
		elements = arr;
		pos = 0;
	}

	// 비었는지 측정 사용안함
	public boolean isEmpty() {
		return pos == 0;

	}

	// 위치더하기 여긴 아직 안 함
	public void add(int index, Object object) {
		if (pos == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		System.arraycopy(elements, index, elements, index + 1, pos - index);
		elements[index] = object;
		pos++;
	}

}
