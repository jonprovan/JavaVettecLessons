import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Doors {

	public static void main(String[] args) throws InterruptedException {
		
		// adjust this to raise/lower the overall sample size
		long totalSize = 100000000;
		
		// adjust this to raise/lower the number of threads
		int threads = 8;
		
		long wins = 0;
		long losses = 0;
		long startTime;
		long endTime;
		double singleThreadRuntime;
		double multiThreadRuntime;
		
		startTime = System.nanoTime();
		
		for (long i = 0; i < totalSize; i++) {
		
			int prizeDoorNumber = ThreadLocalRandom.current().nextInt(3) + 1;
//			System.out.println("Prize is in Door #" + prizeDoorNumber);
//			System.out.println();
			
			int firstDoorChosen = ThreadLocalRandom.current().nextInt(3) + 1;
//			System.out.println("Player chooses Door #" + firstDoorChosen);
//			System.out.println();
			
			int doorOpened = 0;
			
			switch (firstDoorChosen) {
				case 1 :
					if (prizeDoorNumber == 1)
						doorOpened = ThreadLocalRandom.current().nextInt(2) + 2;
					else if (prizeDoorNumber == 2)
						doorOpened = 3;
					else
						doorOpened = 2;
					break;
					
				case 2 :
					if (prizeDoorNumber == 2)
						doorOpened = ThreadLocalRandom.current().nextInt() * 2 + 1;
					else if (prizeDoorNumber == 1)
						doorOpened = 3;
					else
						doorOpened = 1;
					break;
				
				case 3 :
					if (prizeDoorNumber == 3)
						doorOpened = ThreadLocalRandom.current().nextInt(2) + 1;
					else if (prizeDoorNumber == 1)
						doorOpened = 2;
					else
						doorOpened = 1;
					break;
			}
			
//			System.out.println("Host Opens Door #" + doorOpened);
//			System.out.println();
			
			int secondDoorChosen = 0;
			
			switch ("" + firstDoorChosen + doorOpened) {
				case "12" :
					secondDoorChosen = 3;
					break;
					
				case "13" :
					secondDoorChosen = 2;
					break;
					
				case "21" :
					secondDoorChosen = 3;
					break;
					
				case "23" :
					secondDoorChosen = 1;
					break;
					
				case "31" :
					secondDoorChosen = 2;
					break;
					
				case "32" :
					secondDoorChosen = 1;
					break;	
			}
			
//			System.out.println("Player Switches To Door #" + secondDoorChosen);
//			System.out.println();
			
			if (prizeDoorNumber == secondDoorChosen) {
				wins++;
//				System.out.println("Player WINS!");
			}
			else {
				losses++;
//				System.out.println("Player LOSES!");
			}
			
//			System.out.println();
			
		}
		
		endTime = System.nanoTime();
		
		singleThreadRuntime = (double)(endTime - startTime)/1000000000;
		
		System.out.println("TOTAL WINS: " + wins);
		System.out.println("TOTAL LOSSES: " + losses);
		System.out.println("WIN PERCENTAGE: " + (double) wins / (wins + losses) * 100 + "%");
		System.out.println("1-Thread Runtime: " + singleThreadRuntime + " seconds");
		
		
		
		wins = 0;
		losses = 0;
		
		startTime = System.nanoTime();
		
		ExecutorService ex = Executors.newFixedThreadPool(threads);
		List<long[]> chunks = new ArrayList<>();
		long chunkSize = totalSize / threads;
		
		for (int i = 0; i < threads; i++) {
			
			ex.execute(new Runnable() {

				@Override
				public void run() {
					
					int localWins = 0;
					int localLosses = 0;
					
					for (long i = 0; i < chunkSize; i++) {
						
						int prizeDoorNumber = ThreadLocalRandom.current().nextInt(3) + 1;
						
						int firstDoorChosen = ThreadLocalRandom.current().nextInt(3) + 1;
						
						int doorOpened = 0;
						
						switch (firstDoorChosen) {
							case 1 :
								if (prizeDoorNumber == 1)
									doorOpened = ThreadLocalRandom.current().nextInt(2) + 2;
								else if (prizeDoorNumber == 2)
									doorOpened = 3;
								else
									doorOpened = 2;
								break;
								
							case 2 :
								if (prizeDoorNumber == 2)
									doorOpened = ThreadLocalRandom.current().nextInt() * 2 + 1;
								else if (prizeDoorNumber == 1)
									doorOpened = 3;
								else
									doorOpened = 1;
								break;
							
							case 3 :
								if (prizeDoorNumber == 3)
									doorOpened = ThreadLocalRandom.current().nextInt(2) + 1;
								else if (prizeDoorNumber == 1)
									doorOpened = 2;
								else
									doorOpened = 1;
								break;
						}
						
						int secondDoorChosen = 0;
						
						switch ("" + firstDoorChosen + doorOpened) {
							case "12" :
								secondDoorChosen = 3;
								break;
								
							case "13" :
								secondDoorChosen = 2;
								break;
								
							case "21" :
								secondDoorChosen = 3;
								break;
								
							case "23" :
								secondDoorChosen = 1;
								break;
								
							case "31" :
								secondDoorChosen = 2;
								break;
								
							case "32" :
								secondDoorChosen = 1;
								break;	
						}
						
						if (prizeDoorNumber == secondDoorChosen) {
							localWins++;
						}
						else {
							localLosses++;
						}
						
					}
					
					chunks.add(new long[] {localWins, localLosses});
					
				}
				
			});
				
		}
		
		ex.shutdown();
		ex.awaitTermination(1, TimeUnit.MINUTES);
		
		endTime = System.nanoTime();
		
		multiThreadRuntime = (double)(endTime - startTime)/1000000000;
		
		for (long[] chunk : chunks) {
			wins += chunk[0];
			losses += chunk[1];
		}
		
		System.out.println("\nTOTAL WINS: " + wins);
		System.out.println("TOTAL LOSSES: " + losses);
		System.out.println("WIN PERCENTAGE: " + (double) wins / (wins + losses) * 100 + "%");
		System.out.println(threads + "-Thread Runtime: " + multiThreadRuntime + " seconds");
		
		System.out.println("\nMulti-Thread Runtime Savings: " + (double)(int)((1 - multiThreadRuntime / singleThreadRuntime) * 10000)/100 + "%");
			
	}

}