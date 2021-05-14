<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns="http://www.uts.edu.au/31284/ISD-subjects" 
                version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>movies.xsl</title>   
                <link rel="stylesheet" href="css/movie.css"></link>
                              
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="movies">
        <table class="table" id="moviesTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Handbook URL</th>                    
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="movie">      
        <tr>
            <td>
                <a href="">
                    <xsl:value-of select="ID"/>
                </a>
            </td>
            <td>
                <xsl:value-of select="name" />
            </td>
            <td>
                <a href="{url}" target="_blank" >
                    <xsl:value-of select="url" />
                </a>
            </td>            
        </tr>
    </xsl:template>
</xsl:stylesheet>
