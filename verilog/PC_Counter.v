module PC_Counter (
  input signed [10:0] jumpAddress,
  input nextInstr,
  input jump,
  input cmpJump,
  input clk,
  input reset,
  input enable,
  output reg [10:0] pc
);

  always @(posedge clk or posedge reset) begin
    if (reset) begin
      pc <= 11'b0;
    end else if (enable) begin
      if (nextInstr) begin
        pc <= pc + 1;
      end else if (jump | cmpJump) begin
        pc <= pc + jumpAddress;
      end
    end
  end

endmodule