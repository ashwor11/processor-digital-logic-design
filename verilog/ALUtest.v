module ALU_Testbench;

  reg [17:0] operand1, operand2;
  reg [1:0] alu_select;
  reg reset, enable, clk;
  wire [17:0] result;

  // ALU modülünün çağrılması
  ALU uut (
    .operand1(operand1),
    .operand2(operand2),
    .alu_select(alu_select),
    .reset(reset),
    .enable(enable),
    .clk(clk),
    .result(result)
  );

  // Zaman birimi
  initial begin
    $dumpfile("alu_test.vcd");
    $dumpvars(0, ALU_Testbench);

    // Test senaryosu 1: Toplama işlemi
    operand1 = 8'b11001100;
    operand2 = 8'b10101010;
    alu_select = 2'b00;
    reset = 0;
    enable = 1;
    clk = 0;

    #10; // Bekleme süresi
    $display("Result (Addition): %b", result);

    // Test senaryosu 2: AND işlemi
    operand1 = 8'b11001100;
    operand2 = 8'b10101010;
    alu_select = 2'b01;

    #10; // Bekleme süresi
    $display("Result (AND): %b", result);

    // Test senaryosu 3: NAND işlemi
    operand1 = 8'b11001100;
    operand2 = 8'b10101010;
    alu_select = 2'b10;

    #10; // Bekleme süresi
    $display("Result (NAND): %b", result);

    // Test senaryosu 4: NOR işlemi
    operand1 = 8'b11001100;
    operand2 = 8'b10101010;
    alu_select = 2'b11;

    #10; // Bekleme süresi
    $display("Result (NOR): %b", result);

    // Daha fazla test senaryoları eklenebilir...

    $finish;
  end

  // Clock sinyali oluşturulması
  always #5 clk = ~clk;

endmodule