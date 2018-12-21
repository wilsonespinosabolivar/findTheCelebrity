package findTheCebrity;




import org.junit.Assert;
import org.junit.Test;

import com.Globant.operation.FindCelebrity;

public class findCelebrityTest {
		
	@Test
	public void findCelebrityTest() {
		FindCelebrity find = new FindCelebrity();
		Assert.assertEquals(2, find.findCelebrity(new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}}));
		Assert.assertEquals(3, find.findCelebrity(new int[][]{{0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}}));
		Assert.assertEquals(-1, find.findCelebrity(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}));
		Assert.assertEquals(0, find.findCelebrity(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
	}
}
