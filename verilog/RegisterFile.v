module RegisterFile(
  input [3:0] read_addr1,
  input [3:0] read_addr2,
  input [3:0] write_addr,
  input [17:0] write_data,
  input [17:0] write_data_in,
  input write_enable,
  input clk,
  output reg [17:0] data_out1,
  output reg [17:0] data_out2
);

  reg [17:0] registers [0:15];

  always @(posedge clk) begin
    if (write_enable) begin
      registers[write_addr] <= write_data;
    end
    data_out1 <= registers[read_addr1];
    data_out2 <= registers[read_addr2];
  end

endmodule
