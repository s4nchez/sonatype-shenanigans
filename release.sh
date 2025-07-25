echo $NEXUS_USERNAME

./gradlew publish publishToSonatype closeAndReleaseSonatypeStagingRepository \
-Psign=true \
-PreleaseVersion="0.0.0" \
-PsigningKey="$SIGNING_KEY" \
-PsigningPassword="$SIGNING_PASSWORD" \
-PnexusUsername="$NEXUS_USERNAME" \
-PnexusPassword="$NEXUS_PASSWORD"