/*
 * Copyright (C) 2017-2018 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.management.javadsl

import akka.annotation.DoNotInherit
import akka.annotation.InternalApi
import akka.http.javadsl.model.Uri

/**
 * Settings object used to pass through information about the environment the routes will be running in,
 * from the component starting the actual HTTP server, to the [[ManagementRouteProvider]].
 *
 * Not for user extension.
 */
@DoNotInherit
sealed abstract class ManagementRouteProviderSettings {

  /**
   * The "self" base Uri which points to the root of the HTTP server running the route provided by the Provider.
   * Can be used to introduce some self-awareness and/or links to "self" in the routes created by the Provider.
   */
  def selfBaseUri: Uri
}

/**
 * INTERNAL API
 */
@InternalApi private[akka] final case class ManagementRouteProviderSettingsImpl(
    override val selfBaseUri: Uri
) extends ManagementRouteProviderSettings
