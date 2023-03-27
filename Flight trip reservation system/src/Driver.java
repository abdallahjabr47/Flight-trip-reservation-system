import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.List;

public class Driver {
	public static void main(String[] args) throws IOException {
		ArrayList<Trip> list = new ArrayList<Trip>();
		Scanner scan = new Scanner(System.in);
		Seat[][] ragArrayOfSeats = new Seat[31][];
		/*
		 * for (int i = 0; i < 3; i++) { ragArrayOfSeats[i] = new FirstClassSeat[4]; }
		 * 
		 * for (int i = 5; i < 31; i++) { if (!(i == 12)) ragArrayOfSeats[i] = new
		 * EconomySeat[6]; }
		 * 
		 * for (int i = 0; i < 3; i++) { for (int j = 0; j < 4; j++) { char s = 'n'; if
		 * (j == 0) s = 'A'; else if (j == 1) s = 'C'; else if (j == 2) s = 'D'; else if
		 * (j == 3) s = 'F'; ragArrayOfSeats[i][j] = new FirstClassSeat(s, i + 1, s + ""
		 * + i + 1, "Steak", "Carob");
		 * 
		 * } }
		 * 
		 * for (int i = 5; i < 31; i++) { for (int j = 0; j < 6; j++) { if (i != 12) {
		 * char s = 'n'; if (j == 0) s = 'A'; else if (j == 1) s = 'B'; else if (j == 2)
		 * s = 'C'; else if (j == 3) s = 'D'; else if (j == 4) s = 'E'; else if (j == 5)
		 * s = 'F'; ragArrayOfSeats[i][j] = new EconomySeat(s, i + 1, s + "" + i + 1,
		 * "Chicken", "Cola");
		 * 
		 * } } }
		 * 
		 * 
		 * 
		 * Seat[][] ragArrayOfSeats1 = ragArrayOfSeats.clone(); Seat[][]
		 * ragArrayOfSeats2 = ragArrayOfSeats.clone(); Seat[][] ragArrayOfSeats3 =
		 * ragArrayOfSeats.clone(); Seat[][] ragArrayOfSeats4 = ragArrayOfSeats.clone();
		 * Seat[][] ragArrayOfSeats5 = ragArrayOfSeats.clone();
		 */
		int num, index;
		int numOfBusi, numOfEcon;
		int indexForBusinees = 0;
		int indexForEconomy = 0;

		File f1 = new File("Trips.txt");
		FileReader fr = new FileReader(f1);
		String[] tripsf = readString(fr);
		for (int i = 0; i < tripsf.length; i++) {
			String[] tr = tripsf[i].split(":");
			Seat[][] ragArrayOfSeats0 = new Seat[31][];
			for (int io = 0; io < 3; io++) {
				ragArrayOfSeats0[io] = new FirstClassSeat[4];
			}

			for (int io = 5; io < 31; io++) {
				if (!(io == 12))
					ragArrayOfSeats0[io] = new EconomySeat[6];
			}

			for (int io = 0; io < 3; io++) {
				for (int j = 0; j < 4; j++) {
					char s = 'n';
					if (j == 0)
						s = 'A';
					else if (j == 1)
						s = 'C';
					else if (j == 2)
						s = 'D';
					else if (j == 3)
						s = 'F';
					ragArrayOfSeats0[io][j] = new FirstClassSeat(s, io + 1, s + "" + io + 1, "Steak", "Carob");

				}
			}

			for (int io = 5; io < 31; io++) {
				for (int j = 0; j < 6; j++) {
					if (io != 12) {
						char s = 'n';
						if (j == 0)
							s = 'A';
						else if (j == 1)
							s = 'B';
						else if (j == 2)
							s = 'C';
						else if (j == 3)
							s = 'D';
						else if (j == 4)
							s = 'E';
						else if (j == 5)
							s = 'F';
						ragArrayOfSeats0[io][j] = new EconomySeat(s, io + 1, s + "" + io + 1, "Chicken", "Cola");

					}
				}
			}

			list.add(new Trip(ragArrayOfSeats0, tr[0], tr[1], tr[2], tr[3], tr[4], tr[5]));
		}

		/*
		 * list.add(new Trip(ragArrayOfSeats1, "ESP311", "Barcelona", "Beirut", "3985",
		 * "FRI 07:30 pm", "FRI 12:15 pm ")); list.add(new Trip(ragArrayOfSeats2,
		 * "UAE242", "London   ", "Dubai ", "6821", "SUN 11:45 pm", "MON 05:25 am "));
		 * list.add(new Trip(ragArrayOfSeats3, "SYR012", "Damascus ", "Doha  ", "4256",
		 * "SAT 01:30 pm", "SAT 06:30 pm ")); list.add(new Trip(ragArrayOfSeats4,
		 * "KOR334", "Seoul    ", "Milano", "7286", "Mon 11:00 pm", "TUE 08:45 am "));
		 * list.add(new Trip(ragArrayOfSeats5, "PLE231", "Istanbul ", "Nablus", "3420",
		 * "WED 09:30 pm", "THS 01:00 am "));
		 */
		System.out.println("\t\t\t\t\tWelcome to A320 Flight Trip Reservation System :) ");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

		File f2 = new File("Passenger.txt");
		FileReader fr1 = new FileReader(f2);
		String[] passengersf = readString(fr1);
		for (int i = 0; i < passengersf.length; i++) {
			String[] ps = passengersf[i].split(":");
			String[] name = ps[2].split(" ");
			Passenger p = new Passenger(name[0], name[1], ps[3].trim().charAt(0), ps[4], Integer.parseInt(ps[5].trim()),
					ps[6], true, ps[7]);

			int nums = Integer.parseInt(ps[1].substring(1).trim());
			int culomn = 0;
			char s = ps[1].trim().charAt(0);

			if (s == 'A')
				culomn = 0;
			else if (s == 'B')
				culomn = 1;
			else if (s == 'C')
				culomn = 2;
			else if (s == 'D')
				culomn = 3;
			else if (s == 'E')
				culomn = 4;
			else if (s == 'F')
				culomn = 5;

			int indexx = -1;

			for (int u = 0; u < list.size(); u++) {
				if (ps[0].equalsIgnoreCase(list.get(u).getFlightNum())) {
					indexx = u;
					break;
				}
			}
			if (indexx == -1) {
				System.out.println("the trip " + ps[0] + " is not found for passenger " + p.FirstName);
				continue;
			}
			if (nums > 5 && nums != 13 && nums < 32) {
				if (!(list.get(indexx).ragArrayOfSeats[nums - 1][culomn].getSeatReserved())) {
					list.get(indexx).ragArrayOfSeats[nums - 1][culomn].setSeatReserved(true);
					list.get(indexx).ragArrayOfSeats[nums - 1][culomn].setPassenger(p);

				}
				indexForEconomy++;
			}

			if (nums < 3 && nums > 0 && culomn < 4) {
				if (!(list.get(indexx).ragArrayOfSeats[nums - 1][culomn].getSeatReserved())) {
					list.get(indexx).ragArrayOfSeats[nums - 1][culomn].setSeatReserved(true);
					list.get(indexx).ragArrayOfSeats[nums - 1][culomn].setPassenger(p);

					indexForBusinees++;
				}
			}
		}

		int indt = -1;
		System.out.println("Please enter a right Flight Number : ");
		String tripnum = scan.nextLine();
		boolean flagee = false;
		for (int i = 0; i < list.size(); i++)
			if (tripnum.compareTo(list.get(i).getFlightNum()) == 0) {
				flagee = true;
				indt = i;
			}

		while (!flagee) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			System.out.println("Error : Please enter a Flight Number ! ");
			tripnum = scan.nextLine();
			flagee = false;
			for (int i = 0; i < list.size(); i++)
				if (tripnum.compareTo(list.get(i).getFlightNum()) == 0) {
					flagee = true;
					indt = i;
				}
		}
		while (true) {
			printMenu();
			num = scan.nextInt();
			switch (num) {
			case 1: {
				Collections.sort(list);
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				break;
			}
			case 2:
				do {
					System.out.println("Choose 1 or 2 :)");
					System.out.println("1) To reserve a First Class Seat.");
					System.out.println("2) To reserve an Economy seat.");
					index = scan.nextInt();
				} while (index != 1 && index != 2);
				if (index == 1) {
					// 12 the number of all business seats
					if (indexForBusinees < 11) {
						System.out.println("Please enter your First name : ");
						String FirstName = scan.next();
						System.out.println("Please enter your Last name : ");
						String LastName = scan.next();
						System.out.println("Please enter your Gender[M/F] :");
						char Gender = scan.next().charAt(0);
						System.out.println("Please enter your DOB : ");
						String DOB = scan.next();
						System.out.println("Please enter your Passport number : ");
						int PassportNum = scan.nextInt();
						System.out.println("Please enter your Nationality");
						String Nationality = scan.next();
						System.out.println("Do you have an entrance VISA ?[yes/no]");
						boolean HasVISA = scan.next().equals("yes") ? true : false;
						System.out.println("Please enter the HasFlightSeat : ");
						String HasFlightSeat = scan.next();
						if (Gender == 'M' || Gender == 'F' || Gender == 'm' || Gender == 'f') {
							Passenger p = new Passenger(FirstName, LastName, Gender, DOB, PassportNum, Nationality,
									HasVISA, HasFlightSeat);
							boolean flag1 = false;
							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 4; j++) {
									if (!flag1)

										if (!(list.get(indt).ragArrayOfSeats[i][j].getSeatReserved())) {
											list.get(indt).ragArrayOfSeats[i][j].setSeatReserved(true);
											list.get(indt).ragArrayOfSeats[i][j].setPassenger(p);
											flag1 = true;
										} else
											indexForBusinees++;
								}
							}
						} else
							System.out.println("Please enter M or F!!");

					} else {
						System.out.println("All seats are reserverd :) , Try again!");
					}

				} else {
					// 150 the number of all economy seats
					if (indexForEconomy < 150) {
						System.out.println("Please enter your First name : ");
						String FirstName = scan.next();
						System.out.println("Please enter your Last name : ");
						String LastName = scan.next();
						System.out.println("Please enter your Gender[M/F] :");
						char Gender = scan.next().charAt(0);
						System.out.println("Please enter your DOB : ");
						String DOB = scan.next();
						System.out.println("Please enter your Passport number : ");
						int PassportNum = scan.nextInt();
						System.out.println("Please enter your Nationality");
						String Nationality = scan.next();
						System.out.println("Do you have an entrance VISA ?[yes/no]");
						boolean HasVISA = scan.next().equals("yes") ? true : false;
						System.out.println("Please enter the HasFlightSeat : ");
						String HasFlightSeat = scan.next();
						if (Gender == 'M' || Gender == 'F' || Gender == 'm' || Gender == 'f') {
							Passenger p = new Passenger(FirstName, LastName, Gender, DOB, PassportNum, Nationality,
									HasVISA, HasFlightSeat);
							boolean flag = false;
							for (int i = 5; i < 31; i++) {
								for (int j = 0; j < 6; j++) {
									if (!flag)
										if (i != 12) {
											if (!(list.get(indt).ragArrayOfSeats[i][j].getSeatReserved())) {
												list.get(indt).ragArrayOfSeats[i][j].setSeatReserved(true);
												list.get(indt).ragArrayOfSeats[i][j].setPassenger(p);
												flag = true;
											}
											indexForEconomy++;
										}
								}
							}
						} else
							System.out.println("Please enter M or F!!");
					} else {
						System.out.println("All seats are reserverd :) , Try again!");
					}
				}

				break;

			case 3:
				do {
					System.out.println("choose 1 or 2 :)");
					System.out.println("1) To display a First Class Seat.");
					System.out.println("2) To display Econmoy Seat.");
					index = scan.nextInt();
				} while (index != 1 && index != 2);
				System.out.print("Please enter the Seat number : ");
				String seatNumber = scan.next();
				char c = seatNumber.charAt(0);
				int x = -1;
				if (c == 'A')
					x = 0;
				else if (c == 'B')
					x = 1;
				else if (c == 'C')
					x = 2;
				else if (c == 'D')
					x = 3;
				else if (c == 'E')
					x = 4;
				else if (c == 'F')
					x = 5;
				int n = Integer.parseInt(seatNumber.substring(1));
				if (n == 4 || n == 5 || n == 13 || (n < 3 && x == 1) || (n < 3 && x == 4))
					x = -1;
				if (x == -1 || n < 0 || n > 30)
					System.out.println("The seat is not exist :( , cheack your input and Try again!");
				else {
					if (!(list.get(indt).ragArrayOfSeats[n - 1][x].getSeatReserved())) {
						System.out.println("This seat is not reserved :)");
					} else {
						System.out.println(list.get(indt).ragArrayOfSeats[n - 1][x].getPassenger().toString());

					}
				}
				break;

			case 4:
				do {
					System.out.println("choose 1 or 2");
					System.out.println("1- To search for a First name.");
					System.out.println("2- To search for a Last name.");
					index = scan.nextInt();
				} while (index != 1 && index != 2);
				if (index == 1) {
					System.out.print("Please enter the first name :");
					String search = scan.next();
					boolean flag3 = false;
					numOfBusi = 0;
					numOfEcon = 0;

					while (numOfBusi != 12 && list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4] != null) {
						if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getSeatReserved()) {
							if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getPassenger()
									.getFirstName().equals(search)) {
								flag3 = true;
								System.out.println(list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4]
										.getPassenger().toString());
								break;
							}
						}
						numOfBusi++;
					}
					if (!flag3)
						while (numOfEcon != 150) {
							if ((numOfEcon / 6) + 5 != 12)
								if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
										.getSeatReserved()) {
									if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
											.getPassenger().getFirstName().equals(search)) {
										flag3 = true;
										System.out.println(
												list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
														.getPassenger().toString());
									}
								}
							numOfEcon++;
						}
					if (!flag3)
						System.out.println(search + " is not found , Try again!");
				} else {
					System.out.print("Please enter the Last name : ");
					String search = scan.next();
					boolean flag = false;
					numOfBusi = 0;
					numOfEcon = 0;
					while (numOfBusi != 12 && list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4] != null) {
						if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getSeatReserved()) {
							if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getPassenger()
									.getLastName().equals(search)) {
								flag = true;
								System.out.println(list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4]
										.getPassenger().toString());
							}
						}
						numOfBusi++;
					}
					if (!flag)
						while (numOfEcon != 150) {
							if ((numOfEcon / 6) + 5 != 12)
								if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
										.getSeatReserved()) {
									if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
											.getPassenger().getLastName().equals(search)) {
										flag = true;
										System.out.println(
												list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
														.getPassenger().toString());
									}
								}
							numOfEcon++;
						}
					if (!flag)
						System.out.println(search + " is not found , Try Again!");
				}
				break;

			case 5: {
				System.out.println(list.get(indt).toString());
				numOfBusi = 0;
				while (numOfBusi != 12) {
					if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getSeatReserved()) {
						System.out.printf("seat : %c%d , ", (numOfBusi % 4 + 65), ((numOfBusi / 4) + 1));
						System.out.println(
								list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getPassenger().toString());
					}
					numOfBusi++;
				}
				numOfEcon = 0;
				while (numOfEcon != 150) {
					if ((numOfEcon / 6) + 5 != 12) {
						if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].getSeatReserved()) {
							System.out.printf("seat : %c%d , ", (numOfEcon % 6 + 65), ((numOfEcon / 6) + 6));
							System.out.println(list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
									.getPassenger().toString());
						}
					}
					numOfEcon++;
				}
				break;
			}
			case 6: {
				System.out.print("Please enter the first name :");
				String search = scan.next();
				boolean flag6 = false;
				numOfBusi = 0;
				numOfEcon = 0;

				int row = -1, column = -1;
				while (numOfBusi != 12 && list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4] != null) {
					if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getSeatReserved()) {
						if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getPassenger().getFirstName()
								.equals(search)) {
							row = numOfBusi / 4;
							column = numOfBusi % 4;
							flag6 = true;
							System.out.println(list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4]
									.getPassenger().toString());
							break;
						}
					}
					numOfBusi++;
				}

				if (!flag6)
					while (numOfEcon != 150) {
						if ((numOfEcon / 6) + 5 != 12)
							if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].getSeatReserved()) {
								if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].getPassenger()
										.getFirstName().equals(search)) {
									row = (numOfEcon / 6) + 5;
									column = numOfEcon % 6;
									flag6 = true;
									System.out
											.println(list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
													.getPassenger().toString());
								}
							}
						numOfEcon++;
					}
				if (!flag6) {
					System.out.println(search + " is not found , Try again!");
					break;
				}
				Seat raga[][] = list.get(indt).getRagArrayOfSeats();
				Passenger p = raga[row][column].getPassenger();
				index = 3;
				while (index != 1 && index != 2) {
					System.out.print("Please enter the Seat number you want to to change in : ");
					seatNumber = scan.next();
					c = seatNumber.charAt(0);
					x = -1;
					if (c == 'A')
						x = 0;
					else if (c == 'B')
						x = 1;
					else if (c == 'C')
						x = 2;
					else if (c == 'D')
						x = 3;
					else if (c == 'E')
						x = 4;
					else if (c == 'F')
						x = 5;
					n = Integer.parseInt(seatNumber.substring(1).trim());
					if (n == 4 || n == 5 || n == 13)
						x = -1;
					if (x == -1 || n < 0 || n > 30)
						System.out.println("The seat is not exist :( , cheack your input and Try again!");
					else {

						if (!(list.get(indt).ragArrayOfSeats[n - 1][x].getSeatReserved())) {
							index = 1;
							list.get(indt).ragArrayOfSeats[n - 1][x].setSeatReserved(true);
							list.get(indt).ragArrayOfSeats[n - 1][x].setPassenger(p);
							list.get(indt).ragArrayOfSeats[row][column].setSeatReserved(false);
							break;

						} else {

							System.out.println("this seat is reserved");
						}
					}

				}

				break;
			}

			case 7: {
				System.out.println("Please enter the Passport No : ");
				int Delete = scan.nextInt();
				boolean flag7 = false;
				numOfBusi = 0;
				numOfEcon = 0;
				while (numOfBusi != 12 && list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4] != null) {
					if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getSeatReserved()) {
						if (list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getPassenger()
								.getPassportNum() == Delete) {
							list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].setSeatReserved(false);
							list.get(indt).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].setPassenger(null);
							flag7 = true;
						}
					}
					numOfBusi++;
				}
				while (numOfEcon != 150) {
					if ((numOfEcon / 6) + 5 != 12)
						if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].getSeatReserved()) {
							if (list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].getPassenger()
									.getPassportNum() == Delete) {
								flag7 = true;
								list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
										.setSeatReserved(false);
								list.get(indt).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].setPassenger(null);
							}
						}
					numOfEcon++;
				}
				if (!flag7)
					System.out.println(Delete + " is not found , Try Again!");

				break;
			}
			case 8: {
				String trip = "";

				for (int i = 0; i < list.size(); i++)
					trip += list.get(i).forFile() + "\n";

				String pass = "";
				ArrayList<Passenger> al = new ArrayList<Passenger>();

				for (int i = 0; i < list.size(); i++) {
					numOfBusi = 0;
					while (numOfBusi != 12) {
						if (list.get(i).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getSeatReserved()) {
							char s = (char) (numOfBusi % 4 + 65);
							String sn = s + "" + ((numOfBusi / 4) + 1) + "";
							list.get(i).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getPassenger().seatNum = list
									.get(i).getFlightNum() + ":" + sn + ":";

							al.add(list.get(i).ragArrayOfSeats[numOfBusi / 4][numOfBusi % 4].getPassenger());
						}
						numOfBusi++;
					}
					numOfEcon = 0;
					while (numOfEcon != 150) {
						if ((numOfEcon / 6) + 5 != 12) {
							if (list.get(i).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].getSeatReserved()) {

								char s = (char) (numOfEcon % 6 + 65);
								String sn = s + "" + ((numOfEcon / 6) + 6) + "";

								list.get(i).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6]
										.getPassenger().seatNum = list.get(i).getFlightNum() + ":" + sn + ":";

								al.add(list.get(i).ragArrayOfSeats[(numOfEcon / 6) + 5][numOfEcon % 6].getPassenger());
							}
						}
						numOfEcon++;
					}

				}
				Collections.sort(al);
				for (int m = 0; m < al.size(); m++)
					pass += al.get(m).toFile() + "\n";

				writeToFile(trip, f1);
				writeToFile(pass, f2);
				System.out.println("\t\tGood Bye :)");
				System.exit(1);
			}
			default:
				break;
			}
		}
	}

	public static void printMenu() {
		System.out.println("");
		System.out.println("\t\t\t\t\tWelcome to A320 Flight Trip Reservation System :) ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("1) To list all the trips information sorted by the flight number.");
		System.out.println("2) To reserve a new seat (First Class or Economy) for a new passenger.");
		System.out.println("3) To display the passenger information for a specific seat.");
		System.out.println("4) To search for a passenger by first or last name.");
		System.out.println("5) To print a list of all the passengers sorted by passport numbers.");
		System.out.println("6) To change a passenger seat in a specific trip.");
		System.out.println("7) To cancel a passenger reservation.");
		System.out.println("8) To exit execution and save it to files .");

	}

	static String[] readString(FileReader f) {
		// for read the file and return an array of strings
		ArrayList<String> list5 = new ArrayList<String>();
		Scanner s = new Scanner(f);
		while (s.hasNext()) {
			list5.add(s.nextLine());
		}
		String[] s1 = new String[list5.size()];
		for (int j = 0 ; j < s1.length ; j++)
			s1[j] = list5.get(j);
		s.close();
		return s1;
	}

	public static void writeToFile(String str, File file1) throws IOException {
		FileWriter FW = new FileWriter(file1);
		BufferedWriter writer = new BufferedWriter(FW);
		writer.write(str);
		writer.close();
	}
}