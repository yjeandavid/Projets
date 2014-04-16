/* Copyright 2012 Jacques Berger

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package ca.uqam.inf2015.tp1.gestionDonnees;

/**
 * Modification ajout de methodes close et flush
 * @author Claude-Clément YAPO
 */
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWrapper {

    private FileWriter writer;
    
    public FileWriterWrapper(FileWriter writer) {
	this.writer = writer;
    }
    
    public void write(String toWrite) throws IOException {
	writer.write(toWrite);
    }
    
    public void flush() throws IOException {
        writer.flush();
    }
    
    public void close() throws IOException {
        writer.close();
    }
}
