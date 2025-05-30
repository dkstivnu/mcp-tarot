package com.tarot.tools;

import com.jetbrains.exported.JBRApi;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.JsonSchema;

@JBRApi.Service
public class GenPrediccion {


    McpSchema.JsonSchema schema = new McpSchema.JsonSchema();

    McpServerFeatures.SyncToolSpecification syncToolSpecification = new McpServerFeatures.SyncToolSpecification(
            new McpSchema.Tool("GenLectura",
                    "Genera la lectura del tarot a partir de la fecha de nacimiento",
                    schema),
            (exchange, arguments) -> {

                return new McpSchema.CallToolResult(, false);
            }
    );
}
