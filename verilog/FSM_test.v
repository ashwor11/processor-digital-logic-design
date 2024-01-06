module FSM_tb;

  // Parametreler ve sinyaller
  reg alu, st, ld, jump, cmpJump, cmpJumpEnable, clk, reset;
  wire enableWrite, enablePC, enableJUMP, enableCMPJUMP, nextInstruction;

  // FSM modülü
  FSM uut (
    .alu(alu),
    .st(st),
    .ld(ld),
    .jump(jump),
    .cmpJump(cmpJump),
    .cmpJumpEnable(cmpJumpEnable),
    .clk(clk),
    .reset(reset),
    .enableWrite(enableWrite),
    .enablePC(enablePC),
    .enableJUMP(enableJUMP),
    .enableCMPJUMP(enableCMPJUMP),
    .nextInstruction(nextInstruction)
  );

  // Clock sinyali oluştur
  always #5 clk =~clk;

  // Test senaryosu
  initial begin
    // Reset durumu
    reset = 1;
    alu = 0;
    st = 0;
    ld = 0;
    jump = 0;
    cmpJump = 0;
    cmpJumpEnable = 0;

    // Test 1: ALU durumu
    #20 reset = 1;
    #10 reset = 0;
    alu = 1;
    #30 alu = 0;
    

    // Test 2: LD durumu
    ld = 1;
    #30 ld = 0;

    // Test 3: ST durumu
    st = 1;
    #20 st = 0;

    // Test 4: JUMP durumu
     jump = 1;
    #20 jump = 0;

    // Test 5: CMPJUMP durumu
     cmpJump = 1;
    #20 cmpJumpEnable = 1;

    
    
    cmpJumpEnable = 0;

    // Daha fazla test senaryolarını ekleyebilirsiniz.

    #40$finish; // Simülasyonu sonlandır
  end

endmodule