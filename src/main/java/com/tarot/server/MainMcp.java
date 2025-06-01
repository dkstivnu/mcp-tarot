package com.tarot.server;

import com.tarot.tools.GenPrediccion;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpSyncServer;

public class MainMcp {
    public static void main(String[] args) {

        McpSyncServer mcp = new McpTarot().mcpTarot;

        McpServerFeatures.SyncToolSpecification tool1 = new GenPrediccion().generacionPrediccion;

        mcp.addTool(tool1);

        mcp.close();
    }
}
