package com.atraxo.homework3;
//[ZP] where is the iterator defined in the problem

//interface TrackIterator {
//	
//	void nextTrack();
//	void playTrack();
//	void previousTrack();
//	void stopTrack();
//}

interface Iterator1{
	
	boolean hasNext();
	Object next();
}

public class CDPlayer {

	private String[] tracks = { "Track 1", "Track 2", "Track 3" };
	private int currentTrack;

	public void next() {
		
		if(currentTrack < tracks.length)
			if(tracks[currentTrack] != null)
				System.out.println(tracks[++currentTrack]);	
	}
	
	public void play() {
		
		System.out.println(tracks[currentTrack]);
	}
	public void stop() {
		
		currentTrack = 0;
	}
	public void prev() {
		
		if(currentTrack > 0)
			System.out.println(tracks[--currentTrack]);
	}
	
	public void foo(Iterator1 it){
		
		
	}
	
	// in this way is easier..
	
	public Iterator1 iterator(){
		
		return new Iterator1() {
			
			@Override
			public Object next() {
				

				return null;
			}
			
			@Override
			public boolean hasNext() {
				

				return false;
			}
		};
	}
}

//class TraceIterator extends CDPlayer{
//	
//	public TrackIterator getIterator(){
//		return new TrackIterator() {
//			
//			CDPlayer player = new CDPlayer();
//			
//			public void nextTrack(){
//				player.next();
//			}
//			
//			public void playTrack(){
//				player.play();
//			}
//			
//			public void previousTrack(){
//				player.prev();
//			}
//			
//			public void stopTrack(){
//				player.stop();
//			}
//		};
//	}
//}

class StartCD{
	
//	public void foo(TrackIterator trackIterator){
//		trackIterator.nextTrack();
//		trackIterator.playTrack();
//		trackIterator.nextTrack();
//		trackIterator.previousTrack();
//		trackIterator.nextTrack();
//		trackIterator.stopTrack();
//		trackIterator.playTrack();
//	}
	
	public static void main(String[] args){
		
//		StartCD cd = new StartCD();
//		
//		TraceIterator ti = new TraceIterator();
//		cd.foo(ti.getIterator());
	}
}


// ----------------------------------------------------------------------------

