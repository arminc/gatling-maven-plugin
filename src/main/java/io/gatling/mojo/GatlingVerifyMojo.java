/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;

/**
 * Mojo to verify Gatling.
 *
 * @goal verify
 * @phase verify
 *
 */
public class GatlingVerifyMojo extends AbstractMojo {

    /**
     * Uses this folder as the folder where results are stored
     *
     * @parameter property="gatling.resultsFolder" alias="rf" default-value="${basedir}/target/gatling/results"
     * @description Uses this folder as the folder where results are stored
     */
    private File resultsFolder;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        File failure = new File(resultsFolder, "gatling.failed");
        if(failure.exists())
            throw new MojoExecutionException("Gatling failed!");
    }
}
