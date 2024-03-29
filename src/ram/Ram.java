/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Grado en Ingeniería Informática
 * Asignatura: Diseño y Análisis de Algoritmos
 * 
 * @author Daniel Hdez de León
 * 
 * @version 1.0.0
 * 
 * @see Ram
 * Clase que representa la memoria RAM.
 */

package ram;

import ram.components.Alu;
import ram.components.io.ReadInFile;
import ram.components.io.WriteOutFile;
import ram.components.io.ReadRamFile;
import ram.components.memory.Instruction;

public class Ram {
  public static void main(String[] args) {
    // Checkea el debug mode
    int debugMode;
    if (args.length == 4) debugMode = Integer.parseInt(args[3]);
    else debugMode = 0;

    // Read in the input file and create the InputTape
    ReadInFile readInFile = new ReadInFile(args[1]);
    int[] inputTape = readInFile.getInputTape();

    // Read the ram file and create the instructions
    ReadRamFile readRamFile = new ReadRamFile(args[0]);
    Instruction[] instructions = readRamFile.getInstructions();

    // Create the Alu and run the Alu
    Alu alu = new Alu(instructions, inputTape);
    alu.run(debugMode);

    // Write the output file
    WriteOutFile writeOutFile = new WriteOutFile(args[2]);
    writeOutFile.write(alu.getOutputTape());
  }
}