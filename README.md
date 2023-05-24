
# How to

## Step 1 (using bash)
1. `mvn clean package`
2. `make docker-build`
3. `make docker-run`

## Step 2 (using sh)
1. Change `bash` with `sh`
   - Open `./docker/entrypoint.sh`
   - Replace `#!/bin/bash` with `#!/bin/sh` 
2. repeat steps `2` and `3`

