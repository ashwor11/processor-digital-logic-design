module ALU (
  input wire [17:0] operand1,
  input wire [17:0] operand2,
  input wire [1:0] alu_select,
  input wire reset,
  input wire enable,
  input wire clk,
  output reg [17:0] result
);

  always @(posedge clk or posedge reset) begin
    if (reset) begin
      result <= 18'b0;
    end else if (enable) begin
      case (alu_select)
        2'b00: result <= operand1 + operand2; // Toplama
        2'b01: result <= operand1 & operand2; // AND
        2'b10: result <= ~(operand1 & operand2); // NAND
        2'b11: result <= ~(operand1 | operand2); // NOR
        default: result <= 18'b0; // Varsayılan durum
      endcase
    end
  end

endmodule