<%-- 
    Document   : UploadFile
    Created on : Sep 19, 2019, 6:23:36 PM
    Author     : DANIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>
<jsp:useBean id="edicion" class="Revista.Edicion"/>

<%
    
         out.println(request.getParameter("nombreEdicion"));
         
   File file ;
   int maxFileSize = 50000 * 1024;
   int maxMemSize = 5000 * 1024;
   System.out.println(maxFileSize +","+maxMemSize);
   String filePath = "C:/Users/DANIEL/Documents/Programming/RevistasCorrecto/TestPDF/";
   String propertyName ="";
   String value="";
    // Verify the content type
   String contentType = request.getContentType();
   
   if ((contentType.indexOf("multipart/form-data") >= 0)) {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("C:/Users/DANIEL/Documents/Programming/RevistasCorrecto/temp/"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
      
      try { 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);

         // Process the uploaded file items
         Iterator i = fileItems.iterator();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>JSP File upload</title>");  
         out.println("</head>");
         out.println("<body>");
         
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath + 
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath + 
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               if (!file.exists()) fi.write( file );
               out.println("Uploaded Filename: " + filePath + 
               fileName + "<br>");
            } else if(fi.isFormField()){
                //Set bean property
                propertyName = fi.getFieldName();
                value = fi.getString();
                out.print(propertyName+" "); out.println(value+"<br>");
                switch (propertyName){
                    case "revista": edicion.setRevista(value); break;
                    case "nombreEdicion": edicion.setNombreEdicion(value); break;
                    case "revista": edicion.setRevista(value); break;
                    case "revista": edicion.setRevista(value); break;
                    case "revista": edicion.setRevista(value); break;
                    case "revista": edicion.setRevista(value); break;
                }
            }
         }
         out.println(edicion.insert());
         out.println("</body>");
         out.println("</html>");
      } catch(Exception ex) {
         System.out.println(ex);
      }
   } else {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet upload</title>");  
      out.println("</head>");
      out.println("<body>");
      out.println("<p>No file uploaded</p>"); 
      out.println("</body>");
      out.println("</html>");
   }
%>
<% 
 //   out.println( request.getParameter("nombreEdicion"));

%>