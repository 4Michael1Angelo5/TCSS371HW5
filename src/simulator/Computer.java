package simulator;

import java.util.Arrays;

/**
 * The Computer class is composed of registers, memory, PC, IR, and CC.
 * The Computer can execute a program based on the the instructions in memory.
 *
 * @author mmuppa
 * @author acfowler
 * @author dschues1
 * @version 4.1
 */
public class Computer {

	private final static int MAX_MEMORY = 50;
	private final static int MAX_REGISTERS = 8;

	private BitString mRegisters[];
	private BitString mMemory[];
	private BitString mPC;
	private BitString mIR;
	private BitString mCC;

	/**
	 * Initialize all memory addresses to 0, registers to 0 to 7
	 * PC, IR to 16 bit 0s and CC to 000.
	 */
	public Computer() {
		mPC = new BitString();
		mPC.setUnsignedValue(0);
		mIR = new BitString();
		mIR.setUnsignedValue(0);
		mCC = new BitString();
		mCC.setBits(new char[] { '0', '0', '0' });

		mRegisters = new BitString[MAX_REGISTERS];
		for (int i = 0; i < MAX_REGISTERS; i++) {
			mRegisters[i] = new BitString();
			mRegisters[i].setUnsignedValue(i);
		}

		mMemory = new BitString[MAX_MEMORY];
		for (int i = 0; i < MAX_MEMORY; i++) {
			mMemory[i] = new BitString();
			mMemory[i].setUnsignedValue(0);
		}
	}

	// The public accessor methods shown below are useful for unit testing.
	// Do NOT add public mutator methods (setters)!

	/**
	 * @return the registers
	 */
	public BitString[] getRegisters() {
		return copyBitStringArray(mRegisters);
	}

	/**
	 * @return the memory
	 */
	public BitString[] getMemory() {
		return copyBitStringArray(mMemory);
	}

	/**
	 * @return the PC
	 */
	public BitString getPC() {
		return mPC.copy();
	}

	/**
	 * @return the IR
	 */
	public BitString getIR() {
		return mIR.copy();
	}

	/**
	 * @return the CC
	 */
	public BitString getCC() {
		return mCC.copy();
	}

	/**
	 * Safely copies a BitString array.
	 * @param theArray the array to copy.
	 * @return a copy of theArray.
	 */
	private BitString[] copyBitStringArray(final BitString[] theArray) {
		BitString[] bitStrings = new BitString[theArray.length];
		Arrays.setAll(bitStrings, n -> bitStrings[n] = theArray[n].copy());
		return bitStrings;
	}

	/**
	 * Loads a 16 bit word into memory at the given address.
	 * @param address memory address
	 * @param word data or instruction or address to be loaded into memory
	 */
	private void loadWord(int address, BitString word) {
		if (address < 0 || address >= MAX_MEMORY) {
			throw new IllegalArgumentException("Invalid address");
		}
		mMemory[address] = word;
	}

	/**
	 * Loads a machine code program, as Strings.
	 * @param theWords the Strings that contain the instructions or data.
	 */
	public void loadMachineCode(final String ... theWords) {
		if (theWords.length == 0 || theWords.length >= MAX_MEMORY) {
			throw new IllegalArgumentException("Invalid words");
		}
		for (int i = 0; i < theWords.length; i++) {
			final BitString instruction = new BitString();
			instruction.setBits(theWords[i].toCharArray());
			loadWord(i, instruction);
		}
	}





	// The next 6 methods are used to execute the required instructions:
	// BR, ADD, LD, ST, AND, NOT, TRAP

	/**
	 * op   nzp pc9offset
	 * 0000 000 000000000
	 *
	 * The condition codes specified by bits [11:9] are tested.
	 * If bit [11] is 1, N is tested; if bit [11] is 0, N is not tested.
	 * If bit [10] is 1, Z is tested, etc.
	 * If any of the condition codes tested is 1, the program branches to the memory location specified by
	 * adding the sign-extended PCoffset9 field to the incremented PC.
	 */
	public void executeBranch() {
		System.out.println("BR"); // remove this print statement

		// implement the BR instruction here

	}

	/**
	 * op   dr  sr1      sr2
	 * 0001 000 000 0 00 000
	 *
	 * OR
	 *
	 * op   dr  sr1   imm5
	 * 0001 000 000 1 00000
	 *
	 * If bit [5] is 0, the second source operand is obtained from SR2.
	 * If bit [5] is 1, the second source operand is obtained by sign-extending the imm5 field to 16 bits.
	 * In both cases, the second source operand is added to the contents of SR1 and the
	 * result stored in DR. The condition codes are set, based on whether the result is
	 * negative, zero, or positive.
	 */
	public void executeAdd() {
		System.out.println("ADD"); // remove this print statement

		// implement the ADD instruction here

	}

	/**
	 * Performs the load operation by placing the data from PC
	 * + PC offset9 bits [8:0]
	 * into DR - bits [11:9]
	 * then sets CC.
	 */
	public void executeLoad() {
		System.out.println("LD");  // remove this print statement

		// implement the LD instruction here

	}

	/**
	 * Store the contents of the register specified by SR
	 * in the memory location whose address is computed by sign-extending bits [8:0] to 16 bits
	 * and adding this value to the incremented PC.
	 */
	public void executeStore() {
		System.out.println("ST");  // remove this print statement

		// implement the ST instruction here

	}

	/**
	 * op   dr  sr1      sr2
	 * 0101 000 000 0 00 000
	 *
	 * OR
	 *
	 * op   dr  sr1   imm5
	 * 0101 000 000 1 00000
	 *
	 * If bit [5] is 0, the second source operand is obtained from SR2.
	 * If bit [5] is 1, the second source operand is obtained by sign-extending the imm5 field to 16 bits.
	 * In either case, the second source operand and the contents of SR1 are bitwise ANDed
	 * and the result stored in DR.
	 * The condition codes are set, based on whether the binary value produced, taken as a 2’s complement integer,
	 * is negative, zero, or positive.
	 */
	public void executeAnd() {
		System.out.println("AND");   // remove this print statement

		// implement the AND instruction here

	}

	/**
	 * Performs not operation by using the data from the source register (bits[8:6])
	 * and inverting and storing in the destination register (bits[11:9]).
	 * Then sets CC.
	 */
	public void executeNot() {
		BitString destBS = mIR.substring(4, 3);
		BitString sourceBS = mIR.substring(7, 3);
		mRegisters[destBS.getUnsignedValue()] = mRegisters[sourceBS.getUnsignedValue()].copy();
		mRegisters[destBS.getUnsignedValue()].invert();

		// add code here to set the condition code
	}

	/**
	 * Executes the trap operation by checking the vector (bits [7:0]
	 *
	 * vector x21 - OUT
	 * vector x25 - HALT
	 *
	 * @return true if this Trap is a HALT command; false otherwise.
	 */
	public boolean executeTrap() {
		boolean halt = true;

		// implement the TRAP instruction here

		return halt;
	}



	/**
	 * This method will execute all the instructions starting at address 0
	 * until a HALT instruction is encountered.
	 */
	public void execute() {
		BitString opCodeStr;
		int opCode;
		boolean halt = false;

		while (!halt) {
			// Fetch the next instruction
			mIR = mMemory[mPC.getUnsignedValue()];
			// increment the PC
			mPC.addOne();

			// Decode the instruction's first 4 bits
			// to figure out the opcode
			opCodeStr = mIR.substring(0, 4);
			opCode = opCodeStr.getUnsignedValue();

			// What instruction is this?
			if (opCode == 0) { // BR
				executeBranch();
			} else if (opCode == 1) {  // ADD    0001
				executeAdd();
			} else if (opCode == 2) {  // LD     0010
				executeLoad();
			} else if (opCode == 3) {  // ST     0011
				executeStore();
			} else if (opCode == 5) {  // AND    0101
				executeAnd();
			} else if (opCode == 9) {  // NOT    1001
				executeNot();
			} else if (opCode == 15) { // TRAP   1111
				halt = executeTrap();
			} else {
				throw new UnsupportedOperationException("Illegal opCode: " + opCode);
			}
		}
	}

	/**
	 * Displays the computer's state
	 */
	public void display() {
		System.out.println();
		System.out.print("PC ");
		mPC.display(true);
		System.out.print("   ");

		System.out.print("IR ");
		mIR.display(true);
		System.out.print("   ");

		System.out.print("CC ");
		mCC.display(true);
		System.out.println("   ");
		for (int i = 0; i < MAX_REGISTERS; i++) {
			System.out.printf("R%d ", i);
			mRegisters[i].display(true);
			if (i % 3 == 2) {
				System.out.println();
			} else {
				System.out.print("   ");
			}
		}
		System.out.println();
		for (int i = 0; i < MAX_MEMORY; i++) {
			System.out.printf("%3d ", i);
			mMemory[i].display(true);
			if (i % 3 == 2) {
				System.out.println();
			} else {
				System.out.print("   ");
			}
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * The Simulator class is used to load and execute all of the instructions in a machine code program.
	 * A sample machine code program is provided which outputs the characters 9 to 1 to the console.
	 *
	 * @author mmuppa
	 * @author acfowler
	 * @author dschues1
	 * @version 1.2
	 */
	public static class Simulator {

		public static void main(String[] args) {

			Computer myComputer;

			/************************************** */
			/** The next variable - "program" */
			/** allows someone using the simulator (such as a grader) */
			/** to decide what program will be simulated. */
			/** The simulation must load and execute */
			/** instructions found in the "program" array. */
			/**
			/** Recompile your program without further changes */
			/** and see the simulator load and execute the new program. */
			/************************************** */

			/*
			 * To run the machine code program shown below in the actual LC3 simulator we need to append the following
			 * to the top of the program:
			 *
			 * "0011000000000000", // Use address x3000 as the start location in memory for the program
			 */

			String program[] = {
				"0010000000001000",  // LD into R0 x39 which is ASCII 9
				"0010001000001000",  // LD into R1 x-30
				"0001010000000001",  // ADD R2 <- R0 + R1 ; #9 ; R2 is the counter
				"0000010000000100",  // BR if zero skip down to code after the loop
				"1111000000100001",  // TRAP - vector x21 - OUT R0
				"0001000000111111",  // ADD - decrement R0 - the character
				"0001010010111111",  // ADD - decrement R2 - the counter
				"0000111111111011",  // BR - Loop back
				"1111000000100101",  // TRAP - vector x25 - HALT
				"0000000000111001",  // x39
				"1111111111010000"}; // x-30

			/*
			 * This is the assembly program version of the binary
			 * program shown above.
			 * 		 .ORIG x3000
			 *
			 * 		 LD R0 START
			 * 		 LD R1 END
			 *  	 ADD R2 R0 R1
			 * TOP   BRZ DONE
			 * 		 OUT
			 * 		 ADD R0 R0 -1
			 *       ADD R2 R2 -1
			 * 		 BRNZP TOP
			 * DONE  HALT
			 *
			 * START .FILL x39
			 * END   .FILL x-30
			 *
			 * 		 .END
			 */


	//		// Here is another program for testing:
	//		String program[] = {
	//		//A program that uses a loop to add 1 + 2 + 3 + 4 + 5 and save the result (15) in RO
	//				"0101000000100000",   //; clear R0 - R0 will be the SUM
	//				"0101001001100000",   //; clear R1 - R1 will be the loop counter
	//				"0001001001100101",   //; R1 <- R1 + 5 : set the loop counter to 5 - result = 15
	//				"0001000000000001",   //; R0 <- R0 + R1 ; add the loop counter value to the sum
	//				"0001001001111111",	  //; decrement the counter
	//				"0000001111111101",   //; BRnzp do it again if the counter is not yet zero
	//				"1111000000100101"};  //; halt - TRAP with vector x25





			myComputer = new Computer();

			/* Show the initial configuration of the computer. */
			//myComputer.display();

			myComputer.loadMachineCode(program);

			/* Execute the program. */
			/* During execution, the only output to the screen should be */
			/* the result of executing OUT. */

			myComputer.execute();

			/* Show the final configuration of the computer. */
			//System.out.println();
			//myComputer.display();
		}

	}
}
