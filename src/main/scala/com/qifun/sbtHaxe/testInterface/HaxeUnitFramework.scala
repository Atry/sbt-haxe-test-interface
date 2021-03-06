/*
 * sbt-haxe
 * Copyright 2014 深圳岂凡网络有限公司 (Shenzhen QiFun Network Corp., LTD)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

package com.qifun.sbtHaxe.testInterface

import org.scalatools.testing.Framework
import org.scalatools.testing.Logger
import org.scalatools.testing.Runner
import org.scalatools.testing.Fingerprint

private object HaxeUnitFramework {
  private final val FINGERPRINTS: Array[Fingerprint] = Array((new HaxeUnitFingerprint).asInstanceOf[Fingerprint])
}

final class HaxeUnitFramework extends Framework {
  import HaxeUnitFramework.FINGERPRINTS

  final override def name(): String = {
    return "HaxeUnit"
  }

  final override def testRunner(testClassLoader: ClassLoader, loggers: Array[Logger]): Runner = {
    return new HaxeUnitRunner(testClassLoader, loggers)
  }
  
  final override def tests(): Array[Fingerprint] = {
    return FINGERPRINTS
  }

}
