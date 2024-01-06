module PC_Counter_Testbench;

  reg signed [10:0] jumpAddress;
  reg nextInstr, jump, cmpJump, clk, reset, enable;
  wire [10:0] pc;

  // PC_Counter modülünün çağrılması
  PC_Counter uut (
    .jumpAddress(jumpAddress),
    .nextInstr(nextInstr),
    .jump(jump),
    .cmpJump(cmpJump),
    .clk(clk),
    .reset(reset),
    .enable(enable),
    .pc(pc)
  );

  // Zaman birimi
  initial begin
    $dumpfile("pc_counter_test.vcd");
    $dumpvars(0, PC_Counter_Testbench);

    // Test senaryosu 3: Reset
    nextInstr = 0;
    jump = 0;
    cmpJump = 0;
    clk = 0;
    reset = 1;
    enable = 1;

    #5; // Bekleme süresi
    $display("PC: %b", pc);

    // Test senaryosu 1: Next instruction
    nextInstr = 1;
    jump = 0;
    cmpJump = 0;
    clk = 0;
    reset = 0;
    enable = 1;

    #5; // Bekleme süresi
    $display("PC: %b", pc);

    // Test senaryosu 2: Jump
    nextInstr = 0;
    jump = 1;
    jumpAddress = -5;
    clk = 0;
    reset = 0;
    enable = 1;

    #5; // Bekleme süresi
    $display("PC: %b", pc);

    

    

    $finish;
  end

  // Clock sinyali oluşturulması
  always #5 clk = ~clk;

endmodule