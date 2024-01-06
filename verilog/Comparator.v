module Comparator_2sComplement (
  input signed [17:0] input1,
  input signed [17:0] input2,
  output reg zf,
  output reg cf
);

  always @* begin
    if (input1 == input2) begin
      cf = 0;
      zf = 1;
    end else if (input1 > input2) begin
      cf = 0;
      zf = 0;
    end else begin
      cf = 1;
      zf = 0;
    end
  end

endmodule