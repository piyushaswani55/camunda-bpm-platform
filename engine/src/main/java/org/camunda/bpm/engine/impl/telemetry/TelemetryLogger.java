/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.impl.telemetry;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.impl.ProcessEngineLogger;

public class TelemetryLogger extends ProcessEngineLogger {

  public ProcessEngineException schedulingTaskFails(Exception e) {
    return new ProcessEngineException(
        exceptionMessage("010", "Cannot schedule the telemetry task."), e);
  }

  public void schedulingTaskFailsOnEngineStart(Exception e) {
    logWarn("013",
        "Could not start telemetry task. Reason: {} with message '{}'. Set this logger to DEBUG/FINE for the full stacktrace.",
        e.getClass().getSimpleName(),
        e.getMessage());
    logDebug(
        "014", "{} occurred while starting the telemetry task.",
        e.getClass().getCanonicalName(),
        e);
  }

  public ProcessEngineException exceptionWhileRetrievingTelemetryDataRegistryNull() {
    return new ProcessEngineException(
        exceptionMessage("019", "Error while retrieving telemetry data. Telemetry registry was not initialized."));
  }

}
