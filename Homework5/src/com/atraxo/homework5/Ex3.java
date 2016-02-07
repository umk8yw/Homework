package com.atraxo.homework5;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

import objectexplorer.MemoryMeasurer;

// After reading about memory sensitive caches, 
// I understood that they represent Hashmaps with a weak reference to an object, mapped to a key.
// To prove the operation of WeakHashMap I used objectexplorer.MemoryMeasurer, 
// which is available at https://github.com/DimitrisAndreou/memory-measurer.git

public class Ex3 {

	public static void main(String[] args) throws IOException {

		Map<Integer, String> StringCache = new WeakHashMap<>();
		StringCache.put(1, new String("Lorem Ipsum dolor sit amet"));
		StringCache.put(2, new String(
				"consectetur adipiscing elit. Fusce quis nibh quis eros sagittis dignissim. Maecenas tristique id ante vitae pharetra. Praesent quis ultrices mi. Vestibulum mattis commodo facilisis. In ultricies feugiat magna aliquam ullamcorper. Phasellus id dignissim mauris. Nullam viverra lorem id quam tempor, eget efficitur ipsum dictum. Morbi tristique sagittis lectus eu lacinia. Nullam tincidunt, sem a suscipit ullamcorper, dolor velit commodo sapien, eget venenatis leo libero eu odio. Mauris ut enim at turpis dapibus finibus ac in augue."));
		StringCache.put(3, new String(
				"Donec volutpat lacus ligula, vitae aliquet erat molestie sed. Fusce ultricies turpis a consectetur commodo. Praesent in ligula tincidunt, maximus nisi vitae, commodo nisi. Proin dictum vel neque sollicitudin imperdiet. Etiam venenatis justo sed nibh auctor, sed fermentum orci bibendum. Cras posuere, diam in faucibus porta, purus justo dictum nibh, at consequat eros quam non dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Integer eu neque lorem. Proin quis est orci."));
		StringCache.put(4, new String(
				"Duis vestibulum lacus vitae vulputate vestibulum. Morbi tempor mattis eros, ornare laoreet massa accumsan vel. Etiam sed felis a libero vulputate laoreet. Etiam varius volutpat felis, quis vulputate nibh feugiat quis. Donec at turpis id lectus facilisis auctor. In magna nibh, fringilla quis turpis in, aliquam posuere diam. Morbi at euismod leo."));
		StringCache.put(5, new String(
				"Suspendisse eget suscipit diam, vitae interdum dolor. Mauris aliquam consectetur justo, sed sollicitudin massa placerat sed. Phasellus porta ornare dui sit amet feugiat. Maecenas posuere, augue et bibendum ullamcorper, sapien ligula commodo mauris, in dignissim diam lectus quis nibh. Nulla facilisi. Duis at pellentesque eros, ut sodales sem. Fusce felis leo, molestie sed ipsum vel, mattis consequat leo. Morbi pulvinar nisi erat, ut sollicitudin ipsum facilisis vitae. Quisque malesuada luctus dignissim."));
		StringCache.put(6, new String(
				"Suspendisse eget suscipit diam, vitae interdum dolor. Mauris aliquam consectetur justo, sed sollicitudin massa placerat sed. Phasellus porta ornare dui sit amet feugiat. Maecenas posuere, augue et bibendum ullamcorper, sapien ligula commodo mauris, in dignissim diam lectus quis nibh. Nulla facilisi. Duis at pellentesque eros, ut sodales sem. Fusce felis leo, molestie sed ipsum vel, mattis consequat leo. Morbi pulvinar nisi erat, ut sollicitudin ipsum facilisis vitae. Quisque malesuada luctus dignissim."));
		StringCache.put(7, new String(
				"Suspendisse eget suscipit diam, vitae interdum dolor. Mauris aliquam consectetur justo, sed sollicitudin massa placerat sed. Phasellus porta ornare dui sit amet feugiat. Maecenas posuere, augue et bibendum ullamcorper, sapien ligula commodo mauris, in dignissim diam lectus quis nibh. Nulla facilisi. Duis at pellentesque eros, ut sodales sem. Fusce felis leo, molestie sed ipsum vel, mattis consequat leo. Morbi pulvinar nisi erat, ut sollicitudin ipsum facilisis vitae. Quisque malesuada luctus dignissim."));

		// Output: 4640 B
		System.out.println(MemoryMeasurer.measureBytes(StringCache));

		StringCache.remove(2);
		// Output: 3472 B, a large drop, as expected since the element at 2 has
		// a size of around 500B
		System.out.println(MemoryMeasurer.measureBytes(StringCache));

		// Now, The last three elements are of the same length since they are
		// the same string,
		// we remove the last 2 elements, and we notice a small drop in number
		// of bytes.
		// We would expect a large drop since there are more than 1kB
		StringCache.remove(6);
		StringCache.remove(7);
		System.out.println(MemoryMeasurer.measureBytes(StringCache)); // Output
																		// :
																		// 3360
																		// B

		// Now we remove the last reference to the large string, thus we see a
		// large drop in memory use.
		StringCache.remove(5);
		System.out.println(MemoryMeasurer.measureBytes(StringCache)); // Output
																		// :
																		// 2248
																		// B

	}

}
