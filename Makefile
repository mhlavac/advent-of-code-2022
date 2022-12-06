

.PHONY: dev
dev: gradle-wrapper-checksum
	./gradlew dependencies

gradle/wrapper/gradle-wrapper.jar.sha256:
	curl --location --output $@ https://services.gradle.org/distributions/gradle-7.6-wrapper.jar.sha256
	echo "  gradle-wrapper.jar" >> $@

.PHONY: gradle-wrapper-checksum
gradle-wrapper-checksum: gradle/wrapper/gradle-wrapper.jar.sha256
	cd gradle/wrapper; sha256sum --check gradle-wrapper.jar.sha256


# Upgrade Gradle to latest version
# https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:upgrading_wrapper
.PHONY: gradle-upgrade-to-version
gradle-upgrade-to-version:
	./gradlew wrapper
