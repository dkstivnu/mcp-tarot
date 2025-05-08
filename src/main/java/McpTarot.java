import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;

public class McpTarot {

    public StdioServerTransportProvider proveedorTransporte =
            new StdioServerTransportProvider(
                    new ObjectMapper()
            );

    public McpSyncServer mcpTarot = McpServer.sync(proveedorTransporte)
            .serverInfo("MCP TAROT", "0.0.1-SNAPSHOT")
            .capabilities(McpSchema.ServerCapabilities.builder()
                    .tools(true)    // Activar el soporte de Tools
                    .build())
            .build();
}
